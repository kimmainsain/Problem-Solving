const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

let i = 1;
while (i < data.length) {
  const k = parseInt(data[i++]);
  let [max, answer] = [-1, ""];
  for (let j = 0; j < k; j++, i++) {
    const [value, name] = data[i].split(" ");
    if (parseInt(value) > max) {
      max = parseInt(value);
      answer = name;
    }
  }
  console.log(answer);
}