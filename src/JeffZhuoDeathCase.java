import java.util.ArrayList;

public class JeffZhuoDeathCase{
    String age;
    int covidDeath;
    String lastUpdated;
    String endDate;
    String sex;
    String startDate;
    int totalDeath;

    // constructor, getters, setters, and toString
    public JeffZhuoDeathCase(String age, int covidDeath, String lastUpdated, String endDate, String sex, String startDate, int totalDeath) {
        this.age = age;
        this.covidDeath = covidDeath;
        this.lastUpdated = lastUpdated;
        this.endDate = endDate;
        this.sex = sex;
        this.startDate = startDate;
        this.totalDeath = totalDeath;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getCovidDeath() {
        return this.covidDeath;
    }

    public void setCovidDeath(int covidDeath) {
        this.covidDeath = covidDeath;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getTotalDeath() {
        return this.totalDeath;
    }

    public void setTotalDeath(int totalDeath) {
        this.totalDeath = totalDeath;
    }

    public String toString() {
        return "{" +
            " age='" + getAge() + "'" +
            ", totalDeath='" + getTotalDeath() + "'" +
            ", covidDeath='" + getCovidDeath() + "'" +
            ", sex='" + getSex() + "'" +
            ", lastUpdated='" + getLastUpdated() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", startDate='" + getStartDate() + "'" +
            "}";
    }

    /**
     * Find the fist female in the data set
     * @param deathList the data set 
     * @return the first occurrence of a female in the list; -1 if not found
     */
    public static int firstFemaleOfList(ArrayList<JeffZhuoDeathCase> deathList){
        for (JeffZhuoDeathCase deathCase : deathList) {
            if (deathCase.getSex().equals("Female")) {
                return deathList.indexOf(deathCase);
            }
        }
        return -1;
    }

}