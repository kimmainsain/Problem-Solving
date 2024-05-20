const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let index = 1;
let answer = "";

const check = (left, right, str) => {
  while (left < right) {
    if (str[left] !== str[right]) return false;
    left++;
    right--;
  }
  return true;
};

while (index < input.length) {
  const m = input[index++];
  const arr = new Array(m);
  let keep = [];

  for (let i = 0; i < m; i++) arr[i] = input[index++];
  for (let i = 0; i < m; i++) {
    for (let j = i + 1; j < m; j++) {
      const v = arr[i] + arr[j];
      const vv = arr[j] + arr[i];
      if (check(0, v.length - 1, v)) keep.push(v);
      if (check(0, vv.length - 1, vv)) keep.push(vv);
    }
  }
  keep.length === 0 ? (answer += "0\n") : (answer += keep[0] + "\n");
}

console.log(answer);
