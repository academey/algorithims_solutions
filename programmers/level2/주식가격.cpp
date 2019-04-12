// 빠가 같이 풀었다. 여기서 Time 은 index 와 동일하다고 생각하고 풀어도 된다.

#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> prices)
{
    int n = prices.size();
    vector<int> answer(n);

    stack<int> insertTimeStack;
    stack<int> insertIndexStack;
    int currentTime = 0;
    int currentIndex = 0;
    for (int i = 0; i < n; i++)
    {
        int price = prices.at(i);

        if (insertIndexStack.size() == 0)
        {
            insertTimeStack.push(currentTime);
            insertIndexStack.push(i);
        }
        else
        {
            int stackMax = prices.at(insertIndexStack.top());
            if (price >= stackMax)
            {
                insertTimeStack.push(currentTime);
                insertIndexStack.push(i);
            }
            else
            {
                while (!insertIndexStack.empty() && price < prices.at(insertIndexStack.top()))
                {
                    int presentTime = insertTimeStack.top();
                    int willPopIndex = insertIndexStack.top();

                    insertTimeStack.pop();
                    insertIndexStack.pop();
                    answer.at(willPopIndex) = currentTime - presentTime;
                }

                insertTimeStack.push(currentTime);
                insertIndexStack.push(i);
            }
        }

        currentTime++;
    }

    currentTime = currentTime - 1;

    while (!insertTimeStack.empty())
    {
        int presentTime = insertTimeStack.top();
        int willPopIndex = insertIndexStack.top();

        insertTimeStack.pop();
        insertIndexStack.pop();
        answer.at(willPopIndex) = currentTime - presentTime;
    }

    return answer;
}