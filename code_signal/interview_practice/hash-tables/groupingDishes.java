String[][] groupingDishes(String[][] dishes) {
    HashMap<String,  ArrayList<String>> ingredientMap = new HashMap();
    ArrayList<ArrayList<String>> resultArray = new ArrayList<ArrayList<String>>();
    for(int i = 0; i < dishes.length; i++) {
        String dish = dishes[i][0];
        for (int j = 1; j < dishes[i].length; j++) {
            String ingredient = dishes[i][j];
            if (ingredientMap.containsKey(ingredient)) {
                ingredientMap.get(ingredient).add(dish);
            } else {
                ingredientMap.put(ingredient, new ArrayList<String>(){{
                    add(dish);
                }});
            }
        }
    }
    
    for(String ingredient : ingredientMap.keySet()){
        if (ingredientMap.get(ingredient).size() < 2) {
            continue;
        }
        
        Collections.sort(ingredientMap.get(ingredient));
        ingredientMap.get(ingredient).add(0, ingredient);
        
        resultArray.add(ingredientMap.get(ingredient));
    }
    
    Collections.sort(resultArray, new AscendingInteger()); 
    String[][] resultArray2d = new String[resultArray.size()][];
  
    for(int i=0; i<resultArray.size(); i++)
    {
       List<String> row = resultArray.get(i);
       resultArray2d[i] = new String[row.size()];

       for(int j = 0; j < row.size(); j++)
          resultArray2d[i][j] = row.get(j);
    }
    
    return resultArray2d;
}

class AscendingInteger implements Comparator<ArrayList<String>> { 
    @Override public int compare(ArrayList<String> a, ArrayList<String> b) {
        String aIngredient = a.get(0);
        String bIngredient = b.get(0);
        return aIngredient.compareTo(bIngredient); 
    } 
}
