class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteangle=6.0*minutes;
        double hourangle=30*(hour%12)+0.5*minutes;
        double diff=Math.abs(hourangle-minuteangle);
        return Math.min(diff,360.0-diff);
    }
}