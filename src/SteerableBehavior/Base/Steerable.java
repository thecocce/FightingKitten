package SteerableBehavior.Base;

import Objects.Base.BaseModel.AbstractModel;
import SteerableBehavior.Interfaces.ISteerable;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Steerable extends AbstractModel implements ISteerable {
    protected boolean tagged = false;
    public Spatial position = new Spatial();
    public Orientable orientation = new Orientable();
    public Dinamic motion = new Dinamic();
    public Collisionable hitbox = new Collisionable();

    @Override public void setTagged(boolean tagged) { this.tagged = tagged; }
    @Override public boolean isTagged() { return tagged; }

    @Override
    public Vector2 newVector() { return new Vector2(); }

    @Override
    public float vectorToAngle(Vector2 vector) {
        float angulo =(float)Math.atan2(vector.y, vector.x);
        return (angulo + MathUtils.PI2) % MathUtils.PI2;
    }

    @Override
    public Vector2 angleToVector(Vector2 outVector, float angle) {
        outVector.x = (float)Math.cos(angle);
        outVector.y = (float)Math.sin(angle);

        return outVector;
    }

    @Override public void setMaxLinearSpeed(float maxLinearSpeed) { motion.getVelocity().setMax(maxLinearSpeed); }
    @Override public void setMaxLinearAcceleration(float maxAcelLineal) { motion.getAcceleration().setMax(maxAcelLineal); }
    @Override public void setMaxAngularSpeed(float maxAngularSpeed) { motion.getVelocity().setMaxAngular(maxAngularSpeed); }
    @Override public void setMaxAngularAcceleration(float maxAcelAngular) { motion.getAcceleration().setMaxAngular(maxAcelAngular); }

    @Override public Vector2 getPosition() { return position.get(); }
    @Override public float getOrientation() { return orientation.get(); }
    @Override public Vector2 getLinearVelocity() { return motion.getVelocity().get(); }
    @Override public float getAngularVelocity() { return motion.getVelocity().getAngular(); }
    @Override public float getBoundingRadius() { return (hitbox.getWidth() + hitbox.getHeight()) / 4; }
    @Override public float getMaxLinearSpeed() { return motion.getVelocity().getMax(); }
    @Override public float getMaxLinearAcceleration() { return motion.getAcceleration().getMax(); }
    @Override public float getMaxAngularSpeed() { return motion.getVelocity().getMaxAngular(); }
    @Override public float getMaxAngularAcceleration() { return motion.getAcceleration().getMaxAngular(); }
}
