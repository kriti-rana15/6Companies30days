class Pair{
    int alice;
    int bob;
    public Pair(int alice, int bob){
        this.alice = alice;
        this.bob = bob;
    }
}
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> b.alice + b.bob - a.alice - a.bob);
        for(int i = 0; i < aliceValues.length; i++) {
            q.add(new Pair(aliceValues[i], bobValues[i]));
        }
        int alice = 0, bob = 0;
        boolean TurnofAlice = true;
        while(!q.isEmpty()) {
            if(TurnofAlice) alice += q.poll().alice;
            else bob += q.poll().bob;
            TurnofAlice = !TurnofAlice;
        }
        return Integer.compare(alice, bob);
    }
}