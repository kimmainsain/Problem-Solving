const find = (str, left, right) => {
    while (true) {
        if (left < 0 || right > str.length - 1) return right - left - 1;
        if (str[left] !== str[right]) return right - left - 1;
        left--;
        right++;
    }
}

function solution(s)
{
    let answer = 0;
    for (let i = 0; i < s.length; i++) {
        answer = Math.max(find(s, i, i + 2), answer);
        answer = Math.max(find(s, i, i + 1), answer);
    }

    return answer;
}