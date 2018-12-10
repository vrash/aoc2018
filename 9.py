from collections import deque
import time

def winningScore(players, lastmarble):
    #problem struct is a double ended queue
    d = deque([0])
    ans = [0] * players
    #print ans
    for i in range(1, lastmarble + 1):
        if i % 23 == 0:
            d.rotate(7)
            update = i + d.pop()
            ans[i % players] += update
            d.rotate(-1)
        else:
            d.rotate(-1)
            d.append(i)
    return max(ans)

#1
print(winningScore(405, 71700))
#2
start = time.clock()
print(winningScore(405, 7170000))
#time in seconds for part 2
print time.clock() - start
