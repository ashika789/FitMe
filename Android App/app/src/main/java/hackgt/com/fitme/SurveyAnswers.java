package hackgt.com.fitme;

/**
 * Created by Siddarth on 9/27/2015.
 */
public class SurveyAnswers {

    private static SurveyAnswers answers = new SurveyAnswers();

    private int fitnessLevel; // 0 = Not Fit, 1 = Average, 2 = Fit
    private int goalLevel; // 0 = Lose weight, 1 = Maintain weight, 2 = Gain weight
    private int cardioOrWeightsPreference; // 0 = Cardio, 1 = Weights, 2 = Both
    private boolean[] targetAreas; // 0 = arms, 1 = legs, 2 = back, 3 = shoulders, 4 = chest, 5 = core
    private String trainerName;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    private String price;

    public SurveyAnswers() { }

    public static SurveyAnswers getInstance() {
        return answers;
    }

    public boolean[] getTargetAreas() {
        return targetAreas;
    }

    public void setTargetAreas(boolean[] targetAreas) {
        this.targetAreas = targetAreas;
    }

    public int getCardioOrWeightsPreference() {
        return cardioOrWeightsPreference;
    }

    public void setCardioOrWeightsPreference(int cardioOrWeightsPreference) {
        this.cardioOrWeightsPreference = cardioOrWeightsPreference;
    }

    public int getGoalLevel() {
        return goalLevel;
    }

    public void setGoalLevel(int goalLevel) {
        this.goalLevel = goalLevel;
    }

    public int getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(int fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }
}