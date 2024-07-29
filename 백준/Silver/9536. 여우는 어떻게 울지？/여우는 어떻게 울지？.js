const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(data[0]);
const input = data.slice(1);
let index = 0;

for (let tc = 0; tc < n; tc++) {
  const sound = input[index++].split(" ");
  const set = new Set();
  let answer = "";
  while (input[index] !== "what does the fox say?") {
    set.add(input[index++].split(" ")[2]);
  }
  index++;
  for (let i = 0; i < sound.length; i++) {
    if (!set.has(sound[i])) answer += `${sound[i]} `;
  }
  console.log(answer);
}
