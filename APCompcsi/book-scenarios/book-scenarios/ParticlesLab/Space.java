
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Space. The final frontier.
 *
 * @author
 * @version
 */
public class Space extends World
{

    private String lastKey = "";
    private boolean alphaGravityOn = false;
    private boolean betaGammaGravityOn = false;
    private boolean betaGammaElectroMagOn = false;
    private boolean deltaEpsilonElectroMagOn = false;
    private boolean nuclearFamilyOn = false;
    
    //code I added for lists
    ArrayList<Alpha> alpha_list = new ArrayList<Alpha>(); 
    ArrayList<Beta> beta_list = new ArrayList<Beta>(); 
    ArrayList<Gamma> gamma_list = new ArrayList<Gamma>(); 
    ArrayList<Delta> delta_list = new ArrayList<Delta>(); 
    ArrayList<Epsilon> epsilon_list = new ArrayList<Epsilon>(); 
    /**
     * Constructor for objects of class Space.
     *
     */
    public Space()
    {
        super(960, 620, 1);
        updateForceLabel();
    }

    public boolean isAlphaGravityOn() {
        return alphaGravityOn;
    }

    public boolean isBetaGammaGravityOn() {
        return betaGammaGravityOn;
    }
    public boolean isBetaGammaElectroMagOn() {
        return betaGammaElectroMagOn;
    }
    public boolean isDeltaEpsilonElectroMagOn() {
        return deltaEpsilonElectroMagOn;
    }
    public boolean isNuclearFamilyOn() {
        return nuclearFamilyOn;
    }

    private void updateForceLabel() {
        String label =
            (alphaGravityOn ? "1" : "0") +
            (betaGammaGravityOn ? "1" : "0") +
            (betaGammaElectroMagOn ? "1" : "0") +
            (deltaEpsilonElectroMagOn ? "1" : "0") +
            (nuclearFamilyOn ? "1" : "0");
        showText(label, 30, 30);
    }

    private void turnOnAndOffForces(String key) {
        if (key.equals("z")) {
            alphaGravityOn = !alphaGravityOn;
        }
        else if (key.equals("x")) {
            betaGammaGravityOn = !betaGammaGravityOn;
        }
        else if (key.equals("c")) {
            betaGammaElectroMagOn = !betaGammaElectroMagOn;
        }
        else if (key.equals("v")) {
            deltaEpsilonElectroMagOn = !deltaEpsilonElectroMagOn;
        }
        else if (key.equals("b")) {
            nuclearFamilyOn = !nuclearFamilyOn;
        }

       updateForceLabel();
    }



    /** addParticles is called if the user presses 1-5 on the keyboard.
        Add the appropriate particle to Space.
        Use a switch statement for determining which key was pressed.  */
    private void addParticles (String key) {
        if (key != null && !key.equals(lastKey)) {
            int x = (int) (Math.random() * 960);
            int y = (int) (Math.random() * 620); 
            switch(key){
                case "1":   
                    Alpha alpha = new Alpha(); 
                   addObject(alpha, x, y);
                   alpha_list.add(alpha); 
                    break;
                    
                case "2":    
                   Beta beta = new Beta();
                   addObject(beta, x, y); 
                   beta_list.add(beta); 
                    break;
                    
                case "3":
                    Gamma gamma = new Gamma();
                    addObject(gamma, x, y); 
                    gamma_list.add(gamma); 
                    break;
                    
                case "4": 
                    Delta delta = new Delta();
                    addObject(delta, x, y); 
                    delta_list.add(delta);
                    break; 
                case "5":
                    Epsilon epsilon = new Epsilon();
                    addObject(epsilon, x,y );
                    epsilon_list.add(epsilon); 
                    break;
            }
        }
        lastKey = key;
    }
    

    /** removeParticles is called if the user presses 6-0 on the keyboard.
        Removes the appropriate particles from Space.
        Use a switch statement for determining which key was pressed.  */
    private void removeParticles (String key) {
      if (key != null && !key.equals(lastKey)) {

            switch(key){
                case "6":   
                    for (int i = 0; i <alpha_list.size(); i++){
                        Alpha alpha =alpha_list.get(i);
                        removeObject(alpha);
                    }
                   alpha_list.clear(); 
                    break;  
                    
                case "7":    
                  for (int i = 0; i <beta_list.size(); i++){
                    Beta beta =beta_list.get(i);
                    removeObject(beta);
                  }
                   beta_list.clear(); 
                    break;
                    
                case "8":
                    for (int i = 0; i <gamma_list.size(); i++){
                        Gamma gamma =gamma_list.get(i);
                        removeObject(gamma);
                    }
                    gamma_list.clear(); 
                    break;
                    
                case "9": 
                    for (int i = 0; i <delta_list.size(); i++){
                        Delta delta =delta_list.get(i);
                        removeObject(delta);
                    }
                    delta_list.clear(); 
                    break;
                    
                case "0":
                   for (int i = 0; i <epsilon_list.size(); i++){
                        Epsilon epsilon =epsilon_list.get(i);
                        removeObject(epsilon);
                    }
                    epsilon_list.clear(); 
                    break;
            }
        }
        lastKey = key;
    }

    /** 
     * Applies the appropriate forces to the Alpha particles.
     * 
     * This method should make calls to the Particle methods applyGravityForce, 
     * applyElectroMagicForce, and/or applyNuclearFamilyForce.
     * 
     * This method does not need to check the force flag variables.  These are checked in
     * Particle.
     */
    private void alphaForces() {
        for (Alpha alpha: alpha_list){
            for (Alpha alpha2: alpha_list){
                if (!alpha.equals(alpha2)){
                    alpha.applyGravityForce(alpha2);
                }
            }
        }
    }

    /** 
     * Applies the appropriate forces to the Beta particles.
     * 
     * This method should make calls to the Particle methods applyGravityForce, 
     * applyElectroMagicForce, and/or applyNuclearFamilyForce.
     * 
     * This method does not need to check the force flag variables.  These are checked in
     * Particle.
     */
    private void betaForces() {
        for (Beta beta: beta_list){
            for (Alpha alpha: alpha_list){
               beta.applyGravityForce(alpha);
            }
            for (Gamma gamma: gamma_list){
               beta.applyElectroMagicForce(gamma);
            }
            for (Beta beta2: beta_list){
               if (!beta.equals(beta2)){
                   beta.applyElectroMagicForce(beta2);
               }
            }
        }
    }

    /** 
     * Applies the appropriate forces to the Gamma particles.
     * 
     * This method should make calls to the Particle methods applyGravityForce, 
     * applyElectroMagicForce, and/or applyNuclearFamilyForce.
     * 
     * This method does not need to check the force flag variables.  These are checked in
     * Particle.
     */
    private void gammaForces() {
        for (Gamma gamma: gamma_list){
            for (Alpha alpha: alpha_list){
               gamma.applyGravityForce(alpha);
            }
            for (Beta beta: beta_list){
               gamma.applyElectroMagicForce(beta);
            }
            for (Gamma gamma2: gamma_list){
               if (!gamma.equals(gamma2)){
                   gamma.applyElectroMagicForce(gamma2);
               }
            }
        }
    }

    /** 
     * Applies the appropriate forces to the Delta particles.
     * 
     * This method should make calls to the Particle methods applyGravityForce, 
     * applyElectroMagicForce, and/or applyNuclearFamilyForce.
     * 
     * This method does not need to check the force flag variables.  These are checked in
     * Particle.
     */
    private void deltaForces() {
        for (Delta delta: delta_list){
            for(Beta beta: beta_list){
                delta.applyElectroMagicForce(beta);
            }
            for(Gamma gamma: gamma_list){
                delta.applyElectroMagicForce(gamma);
            }
            for(Epsilon epsilon: epsilon_list){
                delta.applyElectroMagicForce(epsilon);
            }
            for (Delta delta2: delta_list){
               if (!delta.equals(delta2)){
                   delta.applyElectroMagicForce(delta2);
                   delta.applyNuclearFamilyForce(delta2);
               }
            }
        }
    }

    /** 
     * Applies the appropriate forces to the Epsilon particles.
     * 
     * This method should make calls to the Particle methods applyGravityForce, 
     * applyElectroMagicForce, and/or applyNuclearFamilyForce.
     * 
     * This method does not need to check the force flag variables.  These are checked in
     * Particle.
     */
    private void epsilonForces() {
        for (Epsilon epsilon: epsilon_list){
            for(Beta beta: beta_list){
                epsilon.applyElectroMagicForce(beta);
            }
            for(Gamma gamma: gamma_list){
                epsilon.applyElectroMagicForce(gamma);
            }
            for(Delta delta: delta_list){
                epsilon.applyElectroMagicForce(delta);
            }
            for (Epsilon epsilon2: epsilon_list){
               if (!epsilon.equals(epsilon2)){
                   epsilon.applyElectroMagicForce(epsilon2);
                   epsilon.applyNuclearFamilyForce(epsilon2);
               }
            }
        }
    }

    /** 
     * Removes a random alpha particle from space.  
     * If there are no alpha particles, the method does nothing.
     */
    public void removeRandomAlphaParticle() {
        if (alpha_list.size() != 0){
            int random = (int) (Math.random() * alpha_list.size()); 
            Alpha alpha =alpha_list.get(random);
            removeObject(alpha);
            alpha_list.remove(random); 
        } 
    }

    /**
     * Removes the most recently added beta particle from space. 
     * Can be called multiple times in a row until no beta particles remain.
     * If there are no beta particles, the method does nothing.
     */
    public void removeMostRecentBetaParticle() {
        if (beta_list.size() != 0){
            Beta beta =beta_list.get(beta_list.size()-1);
            removeObject(beta);
            beta_list.remove(beta_list.size()-1); 
        }
    }

    /** 
     * Removes the 3rd oldest Gamma particle. 
     * Can be called multiple times in a row.
     * If no 3rd oldest Gamma particle exists, the method does nothing.
     */
    public void removeThirdOldestGammaParticle() {
        int third = gamma_list.size()-3; 
        if (third >=0){
            Gamma gamma =gamma_list.get(third);
            removeObject(gamma);
            gamma_list.remove(third); 
        }
    }

    /**
     * Removes the fastest moving delta particle.
     * If there are no delta particles, the method does nothing.
     */
    public void removeFastestDeltaParticle() {
        int temp = 0;
        for (int i = 1; i< delta_list.size(); i++){
            if (delta_list.get(temp).getSpeed() < delta_list.get(i).getSpeed()){
                temp = i; 
            }
            Delta delta = delta_list.get(temp);
            removeObject(delta);
            delta_list.remove(temp); 
        }
    }

    /** 
     * Adds or removes Delta particles to match the number of Epsilon. 
     */
    public void equalizeDeltaToEpsilon() {
        int sizeOfEpsilon = epsilon_list.size();
        while (delta_list.size() != sizeOfEpsilon){
            int x = (int) (Math.random() * 960);
            int y = (int) (Math.random() * 620); 
            if (delta_list.size() < sizeOfEpsilon){
                Delta delta = new Delta();
                addObject(delta, x, y); 
                delta_list.add(delta);
            }
            else if (delta_list.size() > sizeOfEpsilon){
                Delta delta = delta_list.get(delta_list.size()-1);
                removeObject(delta);
                delta_list.remove(delta_list.size()-1); 
            }
        }
    }

    /**
     * Changes all Epsilon particles into Delta particles.
     */
    public void transformEpsilonToDelta() {
        for (int i = 0; i<epsilon_list.size(); i++){
            Delta delta = new Delta();
            int x = (int) epsilon_list.get(i).getExactX();
            int y = (int) epsilon_list.get(i).getExactY(); 
            addObject(delta,x,y);
            Epsilon epsilon = epsilon_list.get(i);
            removeObject(epsilon);
            delta_list.add(delta); 
        }
        epsilon_list.clear(); 
    }

    /**
     * Check for key presses and call the appropriate functions.
     */
    public void checkKeys()
    {
      String key = Greenfoot.getKey();
      if (key != null && !key.equals(lastKey)) {
        if ("zxcvb".contains(key)) {
            turnOnAndOffForces(key);
        }
        else if ("12345".contains(key)) {
            addParticles(key);
        }
        else if ("67890".contains(key)) {
            removeParticles(key);
        }
        else if (key.equals("q")) {
          removeRandomAlphaParticle();
        }
        else if (key.equals("w")) {
          removeMostRecentBetaParticle();
        }
        else if (key.equals("e")) {
          removeThirdOldestGammaParticle();
        }
        else if (key.equals("r")) {
          removeFastestDeltaParticle();
        }
        else if (key.equals("t")) {
          equalizeDeltaToEpsilon();
        }
        else if (key.equals("y")) {
          transformEpsilonToDelta();
        }
      }
      lastKey = key;
    }

    public void act()
    {
        checkKeys();
        alphaForces();
        betaForces();
        gammaForces();
        deltaForces();
        epsilonForces();
    }
}
