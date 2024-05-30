const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const str = input[0];

function solution(str) {
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    for (let j = i + 1; j < str.length; j++) {
      if (str[i] === str[j]) {
        const newArr = str.substring(i + 1, j);
        let cc = 0;
        for (let k = 0; k < newArr.length; k++) {
          let c = 0;
          for (let l = 0; l < newArr.length; l++) {
            if (newArr[k] === newArr[l]) c++;
          }
          if (c === 1) cc++;
        }
        count += cc;
        break;
      }
    }
  }
  return count >> 1;
}
console.log(solution(str));
