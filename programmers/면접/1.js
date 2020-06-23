// 핸드폰을 이용해 알파벳을 입력하기 위해 아래 그림과 같은 키패드를 이용하려 합니다.

// img

// 각 버튼에는 3개씩의 알파벳(1번 버튼에는 '.'(마침표)와 2개의 알파벳)이 적혀있습니다. 버튼을 한 번 누르면 화면에는 각 버튼에 적힌 문자 중 첫 번째 문자가 적힙니다. 이어서 같은 버튼을 두 번, 세 번 연속해 누른다면 화면에 적힌 문자가 순서대로 두 번째, 세 번째 문자로 바뀝니다.
// 예를 들어 A를 입력하기 위해서는 숫자 '2'가 적힌 버튼을 한 번, B를 입력하기 위해서는 두 번, C를 입력하기 위해서는 세 번 눌러야 합니다.
// 한 버튼에 적힌 문자를 연속으로 입력하고 싶을 때는 버튼의 입력 사이에 '0'이 적힌 버튼을 눌려야 합니다. 예를 들어 AB를 입력하고 싶다면

// '2'가 적힌 버튼을 한 번 누릅니다.
// '0'이 적힌 버튼을 한 번 누릅니다.
// '2'가 적힌 버튼을 두 번 누릅니다.
// 만약 A와 B의 입력 사이에 '0'이 적힌 버튼을 누르지 않는다면 C가 입력될 것입니다.

// 당신은 메시지를 보내기 위해 열심히 키패드의 버튼을 눌렀습니다. 메시지를 입력 후, 화면을 보니 문자 대신 숫자가 길게 적혀있었습니다. 키패드의 버튼을 누른 순서대로 알파벳 대신 숫자가 길게 적혀버린 것입니다.
// 이제 화면에 적힌 숫자를 원래 메시지로 복원하려고 합니다. 당신은 버튼을 최대한 적게 눌러서 메시지를 입력했기 때문에 ‘0’이 적힌 버튼은 한 버튼에 적힌 문자를 연속으로 입력하고 싶을 때만 눌렀으며, 화면에 적힌 숫자는 같은 숫자가 최대 연속으로 3개까지만 나타납니다.

// 화면에 적혀있는 숫자들로 이루어진 문자열 s가 매개변수로 주어질 때, 주어진 숫자 문자열을 원래 문장으로 복원하여 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 문자열 s는 0 부터 9까지의 숫자로만 이루어져있으며, 길이는 1 이상 100,000이하입니다.
// s에는 같은 숫자가 최대 3번 까지 연속해서 나올 수 있습니다. 즉, 4 번 이상 연속한 숫자가 나오는 경우(예 : 22225)는 입력으로 주어지지 않습니다.
// s에는 0이 연속해서 나오지 않습니다. 예를 들어 20022와 같은 입력은 주어지지 않습니다.
// s는 0으로 시작하지 않으며, 0으로 끝나지 않습니다.
// 또한, '0'이 적힌 버튼은 한 버튼에 적힌 문자를 연속으로 입력하고 싶을 때만 눌렀기 때문에 2203과 같은 입력은 주어지지 않습니다.
// 정답문자열은 '.'(마침표) 와 알파벳 대문자만 사용해서 return 해주세요.
// 입출력 예
// s	result
// 44335550555666	HELLO
// 9666775553	WORLD
// 2220281	CAT.
// 입출력 예 설명
// 입출력 예 #1
// 44(H)33(E)555(L)0555(L)666(O) 입니다.

// 입출력 예 #2
// 9(W)666(O)77(R)555(L)3(D) 입니다.

// 입출력 예 #3
// 222(C)02(A)8(T)1(.) 입니다.

function solution(s) {
    var answer = '';
    const phoneKeyMap = {
        1: ['.', 'Q', 'Z'],
        2: ['A', 'B', 'C'],
        3: ['D', 'E', 'F'],
        4: ['G', 'H', 'I'],
        5: ['J', 'K', 'L'],
        6: ['M', 'N', 'O'],
        7: ['P', 'R', 'S'],
        8: ['T', 'U', 'V'],
        9: ['W', 'X', 'Y']
    };
    let prevValue;
    let currentOrder = -1;
    for (let i = 0; i < s.length; i++) {
        let value = parseInt(s[i]);
        if (prevValue !== value) {
            if (!!prevValue && prevValue !== 0) {
                answer = answer.concat(phoneKeyMap[prevValue][currentOrder]);    
            }
            prevValue = value;
            currentOrder = 0;
        } else if (prevValue === value) {
            currentOrder++; 
        }
    }
    answer = answer.concat(phoneKeyMap[prevValue][currentOrder]); 
    return answer;
}