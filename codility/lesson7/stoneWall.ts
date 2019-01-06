function solution(H) {
    // write your code in JavaScript (Node.js 8.9.4)
    let blockNumber = 0;
    const stack = Array();
    for (let i = 0; i < H.length; i++) {
        let top = -1;
        if (stack.length > 0) {
            top = stack[stack.length - 1];
        }

        if (H[i] > top) {
            stack.push(H[i]);
            blockNumber++;
        } else if (H[i] < top) {
            while(H[i] < stack[stack.length - 1]) {
                stack.pop();
            }
            if (H[i] !== stack[stack.length - 1]) {
                stack.push(H[i]);
                blockNumber++;
            }
        } else if (H[i] === top) {
          continue;
        }
    }

    return blockNumber;
}