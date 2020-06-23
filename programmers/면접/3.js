// 문제 설명
// 다음과 같이 번식하는 드래곤이 있습니다. 갓 낳은 드래곤 알 하나를 집으로 데려왔을 때, n일 후엔 드래곤과 드래곤 알이 몇 개일지 알아내려 합니다.

// 드래곤 알은 이틀 뒤에 부화합니다.
// 부화한 드래곤은 매일 알을 하나씩 낳습니다.
// 부화한 드래곤은 네 번 알을 낳은 후, 더 이상 알을 낳지 않습니다.
// n이 매개변수로 주어질 때, n일 후 드래곤과 드래곤 알이 몇 개 있는지 return 하는 solution 함수를 완성해주세요.

// 제한 조건
// n은 45 이하인 자연수입니다.
// 입출력 예
// n	return
// 6	12
// 입출력 예 설명
// 일수	0	1	2	3	4	5	6
// 알을 낳을 수 없는 드래곤 수	0	0	0	0	0	0	1
// 알을 낳을 수 있는 드래곤 수	0	0	1	1	2	3	4
// 드래곤 알 수	1	1	1	2	3	5	7
// 0일~1일: 드래곤 알이 하나 있습니다.
// 2일: 초기 드래곤이 부화해, 알을 하나 낳았습니다. 따라서 드래곤 수와 드래곤 알 수의 합은 2입니다.
// 3일: 초기 드래곤이 한 번 더 알을 낳았습니다. 따라서 드래곤 수와 드래곤 알 수의 합은 3입니다.
// 4일: 이틀 차에 낳은 드래곤 알이 부화했습니다. 부화한 드래곤과 초기 드래곤이 알을 하나씩 낳았습니다. 따라서 드래곤 수와 드래곤 알 수의 합은 5입니다.
// 따라서 6일 후 드래곤과 드래곤 알은 총 12개가 됩니다.
function solution(n) {
    var answer = getDragon(n, 0, 0);
    return answer;
}

function getDragon(n, age, eggCount) {
    if (n === 0) {
        return 1;
    }
    if (age < 1) {
        return getDragon(n - 1, age + 1, eggCount);
    } else if (eggCount < 4) {
        return getDragon(n - 1, age + 1, eggCount + 1) + getDragon(n - 1, 0, 0);
    } else {
        return 1;
    }
    
}