const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const truman = new Set(input[1].split(" ").slice(1).map(Number));
const group = input.slice(2).map((v) => v.split(" ").slice(1).map(Number));

function addTruman(index) {
  for (let i = 0; i < group[index].length; i++) {
    truman.add(group[index][i]);
  }
}

function solution() {
  const visited = new Array(m).fill(false);
  loop: while (true) {
    for (let i = 0; i < group.length; i++) {
      if (visited[i]) continue;
      for (let j = 0; j < group[i].length; j++) {
        const value = group[i][j];
        if (truman.has(value)) {
          visited[i] = true;
          addTruman(i);
          continue loop;
        }
      }
    }
    return visited.filter((v) => !v).length;
  }
}

console.log(solution());
