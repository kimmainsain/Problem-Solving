const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = Number(require("fs").readFileSync(path).toString().trim());

console.log(data % 5 == 0 ? data / 5 : parseInt(data / 5) + 1);
