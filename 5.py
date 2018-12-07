l = open("/Users/vrashabhirde/Desktop/aoc/input5.txt").read().splitlines()[0]

o = None
while o != l:
    o = l
    for i in range(0,26):
        l = l.replace(chr(ord("a") + i) + chr(ord("A") + i),"")
        l = l.replace(chr(ord("A") + i) + chr(ord("a") + i),"")
#1
print(len(l))

first = l
b = len(l)
for j in range(0,26):
    l = first
    l = l.replace(chr(ord("a") + j),"")
    l = l.replace(chr(ord("A") + j),"")
    o = None
    while o != l:
        o = l
        for i in range(0,26):
            l = l.replace(chr(ord("a") + i) + chr(ord("A") + i),"")
            l = l.replace(chr(ord("A") + i) + chr(ord("a") + i),"")

    b = len(l) if len(l) < b else b
#2
print(b)
