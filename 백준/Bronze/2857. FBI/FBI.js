const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

let count = [];
for (let i = 0; i < data.length; i++) {
  if (data[i].includes("FBI")) count.push(i + 1);
}
console.log(count.length === 0 ? "HE GOT AWAY!" : count.join(" "));
