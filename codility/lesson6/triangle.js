function solution(A) {
    const N = A.length;
    A.sort((a,b)=>{return a-b});
    if (N < 3) {
        return 0;
    }
    let isExistAnyTriangular = 0;
    for (let i = 0; i <= N - 3; i++) {

        if(A[i] + A[i+1] > A[i+2]) {
            isExistAnyTriangular = 1;
            break;
        }
    }

    return isExistAnyTriangular;
}