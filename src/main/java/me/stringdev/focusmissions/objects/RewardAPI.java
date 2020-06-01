package me.stringdev.focusmissions.objects;

public class RewardAPI {

    private String player;
    private boolean reward1;
    private boolean reward2;
    private boolean reward3;
    private boolean reward4;
    private boolean reward5;
    private boolean reward6;
    private boolean reward7;
    private boolean reward8;
    private boolean reward9;
    private boolean reward10;

    public RewardAPI(String player, int reward1, int reward2, int reward3, int reward4, int reward5, int reward6, int reward7, int reward8, int reward9, int reward10) {
        this.player = player;
        this.reward1 = r(reward1);
        this.reward2 = r(reward2);
        this.reward3 = r(reward3);
        this.reward4 = r(reward4);
        this.reward5 = r(reward5);
        this.reward6 = r(reward6);
        this.reward7 = r(reward7);
        this.reward8 = r(reward8);
        this.reward9 = r(reward9);
        this.reward10 = r(reward10);
    }

    private boolean r(int rpl){
      return rpl == 0 ? false : true;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public boolean isReward1() {
        return reward1;
    }

    public void setReward1(boolean reward1) {
        this.reward1 = reward1;
    }

    public boolean isReward2() {
        return reward2;
    }

    public void setReward2(boolean reward2) {
        this.reward2 = reward2;
    }

    public boolean isReward3() {
        return reward3;
    }

    public void setReward3(boolean reward3) {
        this.reward3 = reward3;
    }

    public boolean isReward4() {
        return reward4;
    }

    public void setReward4(boolean reward4) {
        this.reward4 = reward4;
    }

    public boolean isReward5() {
        return reward5;
    }

    public void setReward5(boolean reward5) {
        this.reward5 = reward5;
    }

    public boolean isReward6() {
        return reward6;
    }

    public void setReward6(boolean reward6) {
        this.reward6 = reward6;
    }

    public boolean isReward7() {
        return reward7;
    }

    public void setReward7(boolean reward7) {
        this.reward7 = reward7;
    }

    public boolean isReward8() {
        return reward8;
    }

    public void setReward8(boolean reward8) {
        this.reward8 = reward8;
    }

    public boolean isReward9() {
        return reward9;
    }

    public void setReward9(boolean reward9) {
        this.reward9 = reward9;
    }

    public boolean isReward10() {
        return reward10;
    }

    public void setReward10(boolean reward10) {
        this.reward10 = reward10;
    }
}
