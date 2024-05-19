const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");
const vali = [
  { lank: "A+", value: 4.5 },
  { lank: "A0", value: 4.0 },
  { lank: "B+", value: 3.5 },
  { lank: "B0", value: 3.0 },
  { lank: "C+", value: 2.5 },
  { lank: "C0", value: 2.0 },
  { lank: "D+", value: 1.5 },
  { lank: "D0", value: 1.0 },
  { lank: "F", value: 0.0 },
];

let sum = 0;
let 학점총합 = 0;
for (let i = 0; i < input.length; i++) {
  const list = input[i].split(" ");
  if (list[2] === "P") continue;
  for (let j = 0; j < vali.length; j++) {
    if (vali[j].lank === list[2]) {
      학점총합 += parseInt(list[1]);
      sum += parseInt(list[1]) * vali[j].value;
      break;
    }
  }
}

console.log(sum / 학점총합);
