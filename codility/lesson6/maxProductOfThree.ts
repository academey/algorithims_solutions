function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)
  const N = A.length;
  A.sort((a, b) => {
    return a - b;
  });

  const result1 = A[N - 3] * A[N - 2] * A[N - 1];
  const result2 = A[0] * A[1] * A[N - 1];

  return result1 > result2 ? result1 : result2;
}
