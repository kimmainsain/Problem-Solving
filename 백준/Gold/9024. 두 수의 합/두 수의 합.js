const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const tc = Number(input.shift());

const tpoint = (left, right, target, arr) => {
  let count = 0;
  let fit = 2147483647;
  while (left < right) {
    const sum = arr[left] + arr[right];
    if (sum == target) {
      left++;
      right--;
    } else if (sum < target) left++;
    else if (sum > target) right--;
    const v = Math.abs(target - sum); // 3
    if (v == fit) count++;
    else if (v < fit) {
      fit = v;
      count = 1;
    }
  }
  console.log(count);
};

const solution = () => {
  for (let t = 0; t < tc; t++) {
    const [n, m] = input.shift().split(" ").map(Number);
    const arr = input
      .shift()
      .split(" ")
      .map(Number)
      .sort((a, b) => a - b);
    tpoint(0, n - 1, m, arr);
  }
};

solution();
