const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

let max = -1;
const answer = [];
data.forEach((v) =>
  v
    .replace(/\s+/g, " ")
    .trim()
    .split(" ")
    .forEach((value) => {
      const word = value.replace(/[^a-zA-Z-]/g, "");
      if (max < word.length) {
        max = word.length;
        if (word !== "E-N-D") answer.push(word);
      }
    })
);

console.log(answer[answer.length - 1].toLowerCase());
