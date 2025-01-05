class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new HashMap<>());
    }

    // Recursive function with memoization
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }

        // Base case: Cost without any special offer
        int minCost = directPurchase(price, needs);

        // Try each special offer
        for (List<Integer> offer : special) {
            if (isValid(offer, needs)) {
                // Apply the offer
                List<Integer> remainingNeeds = applyOffer(offer, needs);
                // Recursive call
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, remainingNeeds, map));
            }
        }

        map.put(needs, minCost);
        return minCost;
    }

    // Calculate the direct purchase cost (without special offers)
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        return cost;
    }

    // Check if a special offer can be applied to the current needs
    private boolean isValid(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                return false;
            }
        }
        return true;
    }

    // Apply a special offer to the current needs and return the remaining needs
    private List<Integer> applyOffer(List<Integer> offer, List<Integer> needs) {
        List<Integer> remainingNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            remainingNeeds.add(needs.get(i) - offer.get(i));
        }
        return remainingNeeds;
    }
}
