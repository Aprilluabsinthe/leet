public class 1423._Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int [] frontSetOfCards = new int[k+1];
        int [] rearSetOfCards = new int[k+1];
        
        for (int i = 0 ; i < k ; i++){
            frontSetOfCards[i+1] = cardPoints[i] + frontSetOfCards[i];
            rearSetOfCards[i+1] = cardPoints[n-i-1] + rearSetOfCards[i];
        }
        
        int maxScore = 0;
        for(int i = 0 ; i <= k ; i++){
            int curScore = rearSetOfCards[i] + rearSetOfCards[k-i];
            maxScore = Math.max(curScore,maxScore);
        }
        return maxScore;
    }
}
