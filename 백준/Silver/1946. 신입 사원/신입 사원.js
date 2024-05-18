const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const calculate = (documentRank) => {
  let min = 100_001;
  let answer = 0;
  for (let i = 0; i < documentRank.length; i++) {
    if (documentRank[i] < min) {
      min = documentRank[i];
      answer++;
    }
  }
  console.log(answer);
};

let index = 1;
while (index < input.length) {
  const n = parseInt(input[index++]);
  const documentRank = new Array(n);
  for (let i = 0; i < n; i++) {
    const [document, interview] = input[index++].split(" ").map(Number);
    documentRank[document - 1] = interview;
  }
  calculate(documentRank);
}
