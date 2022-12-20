n = int(input())  # 단어의 개수 n
count = n

for _ in range(n):
    word = input()
    for j in range(len(word) - 1):
        if word[j] != word[j + 1]:
            if word[j] in word[j + 1:]:
                count -= 1
                break
print(count)