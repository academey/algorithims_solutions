String findProfession(int level, int pos) {
    int currentPos = pos - 1;
    boolean sameAsParent = true;
    
    for (int i = level; i > 1; i--) {
        if (currentPos % 2 == 1) {
            sameAsParent = !sameAsParent;
        }
        currentPos /= 2;
    }
    
    if (sameAsParent) {
        return "Engineer";    
    } else {
        return "Doctor";
    }
}
//                 E
//            /         \
//           E           D
//         /   \        /  \
//        E     D      D    E
//       / \   / \    / \   / \
//      E   D D   E  D   E E   D
//  E  D  D E D E ED DE ED ED  D E
 
//  level 1 E
//  level 2 E D
//  level 3 ED DE
//  level 4 EDDE DEED
//  level 5 EDDEDEED DEEDEDDE
//  level 6 EDDEDEEDDEEDEDDE 