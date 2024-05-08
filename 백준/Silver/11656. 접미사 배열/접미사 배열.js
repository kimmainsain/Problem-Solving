// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString().trim();
const solution = () => {
  const arr = [];
  for (let i = 0; i < input.length; i++) {
    arr.push(input.slice(i, input.length));
  }
  arr.sort();
  console.log(arr.join("\n"));
};

solution();
