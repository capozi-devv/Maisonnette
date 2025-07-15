package net.capozi.maisonnette.common.entity.custom;

import java.util.EnumSet;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SpecterEntity extends FlyingEntity {
	public SpecterEntity(EntityType<? extends FlyingEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new SpecterMoveControl(this);
	}

	public static DefaultAttributeContainer.Builder createSpecterAttributes() {
		return createMobAttributes()
				.add(EntityAttributes.GENERIC_FLYING_SPEED, 1f);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(5, new FlyRandomlyGoal(this));
		this.goalSelector.add(5, new LookAroundGoal(this));
	}

	private static class SpecterMoveControl extends MoveControl {
		private final SpecterEntity specterEntity;
		private int collisionCheckCooldown;

		public SpecterMoveControl(SpecterEntity specterEntity) {
			super(specterEntity);
			this.specterEntity = specterEntity;
		}

		public void tick() {
			if (this.state == State.MOVE_TO) {
				if (this.collisionCheckCooldown-- <= 0) {
					this.collisionCheckCooldown += this.specterEntity.getRandom().nextInt(5) + 2;
					Vec3d vec3d = new Vec3d(this.targetX - this.specterEntity.getX(),
							this.targetY - this.specterEntity.getY(),
							this.targetZ - this.specterEntity.getZ());
					double d = vec3d.length();
					vec3d = vec3d.normalize();
					if (this.willCollide(vec3d, MathHelper.ceil(d))) {
						this.specterEntity.setVelocity(this.specterEntity.getVelocity()
								.add(vec3d.multiply(0.1)));
					} else {
						this.state = State.WAIT;
					}
				}

			}
		}

		private boolean willCollide(Vec3d direction, int steps) {
			Box box = this.specterEntity.getBoundingBox();

			for (int i = 1; i < steps; ++i) {
				box = box.offset(direction);
				if (!this.specterEntity.getWorld().isSpaceEmpty(this.specterEntity, box)) {
					return false;
				}
			}

			return true;
		}
	}

	static class FlyRandomlyGoal extends Goal {
		private final SpecterEntity specterEntity;
		private int cooldown = 0;

		public FlyRandomlyGoal(SpecterEntity specterEntity) {
			this.specterEntity = specterEntity;
			this.setControls(EnumSet.of(Control.MOVE));
		}

		@Override
		public boolean canStart() {
			if (cooldown > 0) {
				cooldown--;
				return false;
			}

			MoveControl moveControl = this.specterEntity.getMoveControl();
			if (!moveControl.isMoving()) {
				return true;
			} else {
				double dx = moveControl.getTargetX() - this.specterEntity.getX();
				double dy = moveControl.getTargetY() - this.specterEntity.getY();
				double dz = moveControl.getTargetZ() - this.specterEntity.getZ();
				double distanceSq = dx * dx + dy * dy + dz * dz;
				return distanceSq < 1.0 || distanceSq > 3600.0;
			}
		}

		@Override
		public boolean shouldContinue() {
			return false;
		}

		@Override
		public void start() {
			Random random = this.specterEntity.getRandom();

			double x = this.specterEntity.getX() + (random.nextDouble() - 0.5) * 32.0;
			double y = this.specterEntity.getY() + (random.nextDouble() - 0.5) * 16.0;
			double z = this.specterEntity.getZ() + (random.nextDouble() - 0.5) * 32.0;

			this.specterEntity.getMoveControl().moveTo(x, y, z, 1.0F);

			// Set idle cooldown (e.g. 4–6 seconds)
			this.cooldown = 80 + random.nextInt(40); // 40 to 80 ticks
		}
	}
}
