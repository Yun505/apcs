import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * A 'Particle' is a small object in space that has a mass and a charge. 
 * 
 */

public class Particle extends SmoothMover
{
    private static final double GRAVITY_C = 5.0;
    private static final double ELECTROMAGIC_C = 50000.0;
    private static final double NUCLEAR_FARCE_C = 1.0;
    
    private static final Color defaultColor = new Color(255, 216, 0);
    private double mass;
    private double charge;
    
    /**
     * Construct a Particle with default size, mass, velocity and color.
     */
    public Particle()
    {
        this (20, 300, 0.0, new Vector(0, 0.0), defaultColor);
    }
    
    /**
     * Construct a Particle with a specified size, mass, velocity and color.
     */
    public Particle(int size, double mass, double charge, Vector velocity, Color color)
    {
        this.mass = mass;
        this.charge = charge;
        addToVelocity(velocity);
        GreenfootImage image = new GreenfootImage (size, size);
        //draw the image
        image.setColor(color);
        image.fillOval(0, 0, size-1, size-1);
        image.setColor(Color.BLACK);
        image.fillOval( (int) (size * 0.75), (int) ( 0.15 * size), (int)(size * .2),(int)(size * .2));
        image.fillOval( (int) (size * 0.75), (int) ( 0.65 * size), (int)(size * .2),(int)(size * .2));
        setImage (image);
    }

    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
    
    /**
     * Return the charge of this body.
     */
    public double getCharge()
    {
        return charge;
    }
    
    /**
     * Set the mass of this body. 
     */
    public void setMass(double mass)
    {
        this.mass = mass;
    }
    
    /**
     * Set the charge of this body.
     */
    public void setCharge(double charge)
    {
        this.charge = charge;
    }
    
    
    /**
     * Decelerate if above certain speeds.
     */ 
    private void boundSpeed(){
        if (getSpeed() > 50)
        {
            accelerate (0.6);
        }
        else if (getSpeed() > 20)
        {
            accelerate (0.75);
        }
        else if (getSpeed() > 7) 
        {
            accelerate (0.9);  
        }
    }
    
    /**
     * Check whether we have hit the edge of the universe. If so, bounce off it.
     */
    private void bounceAtEdge()
    {
        if (getExactX() < 0.01){
            setLocation(0.01, getExactY());
            invertHorizontalVelocity();
        }
        else if(getExactX() > getWorld().getWidth()-0.01) {
            setLocation(getWorld().getWidth()-0.01, getExactY());
            invertHorizontalVelocity();
        }
        if (getExactY() < 0.01){
            setLocation(getExactX(), 0.01);
            invertVerticalVelocity();
        }
        else if(getExactY() > getWorld().getHeight()-0.01) {
             setLocation(getExactX(), getWorld().getHeight()-0.01);
            invertVerticalVelocity();
        }
    }
    
    /**
     * Act. That is: apply  the gravitation forces from
     * all other bodies around, and then move.
     */
    public void act() 
    {
        turn();
        move();
        boundSpeed();
        bounceAtEdge();
    }
    
    /**
     * Apply the force of gravity (which depends on mass and distance)
     * of a given body "other" to this one.
     * (Force is applied for one time unit; dt==1.)
     */
    public void applyGravityForce(Particle other)
    {
        if (this instanceof Alpha && !((Space)getWorld()).isAlphaGravityOn())
            return;

        if ((this instanceof Beta || this instanceof Gamma) && !((Space)getWorld()).isBetaGammaGravityOn())
            return;
                       
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector dv = new Vector (dx, dy); //sets direction correctly; length still invalid
        double distance = Math.sqrt (dx*dx + dy*dy);
        double force = GRAVITY_C * this.mass * other.mass / (distance * distance);
        double acceleration = force / this.mass;
        if(!Double.isNaN(acceleration)){
            dv.setLength (acceleration);
            addToVelocity (dv);
        }
    }
    
    /**
     * Apply the force of "electromagic" (which depends on charge and distance)
     * of a given body "other" to this one.
     * (Force is applied for one time unit; dt==1.)
     */
    public void applyElectroMagicForce(Particle other)
    {
        if ((this instanceof Beta || this instanceof Gamma) && !((Space)getWorld()).isBetaGammaElectroMagOn())
            return;

        if ((this instanceof Delta || this instanceof Epsilon) && !((Space)getWorld()).isDeltaEpsilonElectroMagOn())
            return;
            
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector dv = new Vector (dx, dy); //sets direction correctly; length still invalid
        double distance = Math.sqrt (dx*dx + dy*dy);
        double force = - ELECTROMAGIC_C * this.charge * other.charge / (distance * distance);
        //double vector_dot_prod = this.getSpeed() * other.getSpeed() * Math.cos(this.getDirection() - other.getDirection());
        //force *= vector_dot_prod;
        double acceleration = force / this.mass;
        if(!Double.isNaN(acceleration)){
            dv.setLength (acceleration);
            addToVelocity (dv);
        }
    }
    
    /**
     * Apply the force of "nuclear family" (which depends on distance)
     * of a given body "other" to this one.
     * (Force is applied for one time unit; dt==1.)
     */
    public void applyNuclearFamilyForce(Particle other)
    {
        if (!((Space)getWorld()).isNuclearFamilyOn())
            return;
            
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector dv = new Vector (dx, dy); //sets direction correctly; length still invalid
        double distance = Math.sqrt(dx*dx + dy*dy);
        if(distance == 0.0)
            return;
        double force = NUCLEAR_FARCE_C * distance ;
        double acceleration = force / this.mass;
        if(!Double.isNaN(acceleration)){
            dv.setLength (acceleration);
            addToVelocity (dv);
        }
    }
    
}
