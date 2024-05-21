const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const money = parseInt(input[0]);
const arr = input[1].split(" ").map(Number);

let bnpMoney = money;
let timingMoney = money;
let bnp = 0;
let timing = 0;
let asc = 0;
let desc = 0;
let before = undefined;

for (let i = 0; i < arr.length; i++) {
  if (bnpMoney >= arr[i]) {
    bnp += parseInt(bnpMoney / arr[i]);
    bnpMoney = bnpMoney % arr[i];
  }
  if (before === undefined) {
    before = arr[i];
    continue;
  }
  if (before < arr[i]) {
    asc++;
    desc = 0;
  } else if (before > arr[i]) {
    asc = 0;
    desc++;
  } else {
    asc = 0;
    desc = 0;
  }
  if (asc === 3) {
    timingMoney += timing * arr[i];
    timing = 0;
    asc = 0;
  } else if (desc === 3) {
    timing += parseInt(timingMoney / arr[i]);
    timingMoney = timingMoney % arr[i];
    desc = 0;
  }
  before = arr[i];
}

if (bnp * arr[13] + bnpMoney > timing * arr[13] + timingMoney)
  console.log("BNP");
else if (bnp * arr[13] + bnpMoney == timing * arr[13] + timingMoney)
  console.log("SAMESAME");
else console.log("TIMING");
