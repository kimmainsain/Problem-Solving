const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1);

function vali(num) {
  return num < 10 ? "0" + num : num;
}

function solution(n, input) {
  const arr = [];
  for (let i = 0; i < input.length; i++) {
    const [name, ...birthdayArr] = input[i].split(" ");
    const birthday =
      birthdayArr[2] + vali(birthdayArr[1]) + vali(birthdayArr[0]);
    arr.push([name, parseInt(birthday)]);
  }
  arr.sort((a, b) => a[1] - b[1]);
  return arr[arr.length - 1][0] + "\n" + arr[0][0];
}

console.log(solution(n, arr));
