const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

let [leftS, rightS] = input.shift().split(" ");
const zoac = input.shift();

let answer = 0;

const isLeft = "qwertasdfgzxcv";
const keyboard = ["qwertyuiop", "asdfghjkl", "zxcvbnm"];

const left = [];
const right = [];

const solve = () => {
  keyboard.map((key, i) => {
    if (key.indexOf(leftS) != -1) left.push([i, key.indexOf(leftS)]);
    if (key.indexOf(rightS) != -1) right.push([i, key.indexOf(rightS)]);
  });
  for (let i = 0; i < zoac.length; i++) {
    const value = zoac.charAt(i);
    if (isLeft.indexOf(value) != -1) {
      keyboard.map((key, index) => {
        const x = key.indexOf(value);
        if (key.indexOf(value) != -1) {
          const v = left.shift();
          answer += Math.abs(v[0] - index) + Math.abs(v[1] - x) + 1;
          left.push([index, x]);
        }
      });
    } else {
      keyboard.map((key, index) => {
        const x = key.indexOf(value);
        if (x != -1) {
          const v = right.shift();
          answer += Math.abs(v[0] - index) + Math.abs(v[1] - x) + 1;
          right.push([index, x]);
        }
      });
    }
  }
  console.log(answer);
};

solve();
