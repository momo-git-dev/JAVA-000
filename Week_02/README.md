学习笔记

1、使用GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。

java  -XX:+UseSerialGC -Xms512m  -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

正在执行…
[Full GC (Allocation Failure) [Tenured: 349443K->349543K(349568K), 0.0636665 secs] 506620K->377647K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0637092 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 

[Full GC (Allocation Failure) [Tenured: 349543K->349456K(349568K), 0.0377351 secs] 506143K->392336K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0377725 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 

[Full GC (Allocation Failure) [Tenured: 349538K->349009K(349568K), 0.0513502 secs] 506779K->393194K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0513880 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

[Full GC (Allocation Failure) [Tenured: 349508K->349397K(349568K), 0.0578768 secs] 506748K->402146K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0579141 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

[Full GC (Allocation Failure) [Tenured: 349566K->348961K(349568K), 0.0604681 secs] 506801K->379260K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0605068 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

[Full GC (Allocation Failure) [Tenured: 349490K->349301K(349568K), 0.0422637 secs] 506734K->392757K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0423017 secs] [Times: user=0.04 sys=0.00, real=0.04 secs] 

执行结束!共生成对象次数:373805

Heap

 def new generation   total 157248K, used 92094K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

  eden space 139776K,  65% used [0x00000007a0000000, 0x00000007a59ef8b0, 0x00000007a8880000)

  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

 tenured generation   total 349568K, used 349301K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

   the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bffbd700, 0x00000007bffbd800, 0x00000007c0000000)

 Metaspace       used 2739K, capacity 4490K, committed 4864K, reserved 1056768K

  class space    used 296K, capacity 386K, committed 512K, reserved 1048576K


java  -XX:+UseParallelGC -Xms512m  -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

正在执行…

[Full GC (Ergonomics) [PSYoungGen: 58832K->16582K(116736K)] [ParOldGen: 349597K->349035K(349696K)] 408429K->365617K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0610246 secs] [Times: user=0.20 sys=0.00, real=0.06 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58880K->16116K(116736K)] [ParOldGen: 349035K->349027K(349696K)] 407915K->365143K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0605525 secs] [Times: user=0.19 sys=0.01, real=0.06 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58880K->16328K(116736K)] [ParOldGen: 349027K->349365K(349696K)] 407907K->365693K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0642680 secs] [Times: user=0.21 sys=0.00, real=0.06 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58862K->17391K(116736K)] [ParOldGen: 349365K->349332K(349696K)] 408228K->366723K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0574668 secs] [Times: user=0.20 sys=0.00, real=0.06 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58808K->20783K(116736K)] [ParOldGen: 349332K->348624K(349696K)] 408140K->369407K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0611317 secs] [Times: user=0.20 sys=0.00, real=0.07 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58839K->16419K(116736K)] [ParOldGen: 348624K->349604K(349696K)] 407463K->366023K(466432K), [Metaspace: 2733K->2733K(1056768K)], 0.0603492 secs] [Times: user=0.20 sys=0.01, real=0.06 secs] 

执行结束!共生成对象次数:113658

Heap

 PSYoungGen      total 116736K, used 18478K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)

  eden space 58880K, 31% used [0x00000007b5580000,0x00000007b678ba88,0x00000007b8f00000)

  from space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)

  to   space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)

 ParOldGen       total 349696K, used 349604K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)

  object space 349696K, 99% used [0x00000007a0000000,0x00000007b55690f8,0x00000007b5580000)

 Metaspace       used 2739K, capacity 4490K, committed 4864K, reserved 1056768K

  class space    used 296K, capacity 386K, committed 512K, reserved 1048576K


java  -XX:+UseConcMarkSweepGC -Xms512m  -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

正在执行…
[CMS-concurrent-preclean-start]

[CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[CMS-concurrent-abortable-preclean-start]

[CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[GC (CMS Final Remark) [YG occupancy: 39909 K (157248 K)][Rescan (parallel) , 0.0004026 secs][weak refs processing, 0.0000053 secs][class unloading, 0.0002228 secs][scrub symbol table, 0.0003368 secs][scrub string table, 0.0001555 secs][1 CMS-remark: 349501K(349568K)] 389410K(506816K), 0.0011794 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-sweep-start]

[CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

[CMS-concurrent-reset-start]

[CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [ParNew: 157197K->157197K(157248K), 0.0000149 secs][CMS: 348571K->349546K(349568K), 0.0644898 secs] 505768K->367132K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0645545 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 

[GC (CMS Initial Mark) [1 CMS-initial-mark: 349546K(349568K)] 367229K(506816K), 0.0001805 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-mark-start]

[CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-preclean-start]

[CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[CMS-concurrent-abortable-preclean-start]

[CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[GC (CMS Final Remark) [YG occupancy: 41047 K (157248 K)][Rescan (parallel) , 0.0003857 secs][weak refs processing, 0.0000062 secs][class unloading, 0.0002195 secs][scrub symbol table, 0.0004667 secs][scrub string table, 0.0001829 secs][1 CMS-remark: 349546K(349568K)] 390594K(506816K), 0.0013351 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-sweep-start]

[CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-reset-start]

[CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [ParNew: 157210K->157210K(157248K), 0.0000155 secs][CMS: 348897K->349417K(349568K), 0.0707939 secs] 506107K->365225K(506816K), [Metaspace: 2733K->2733K(1056768K)], 0.0708662 secs] [Times: user=0.07 sys=0.00, real=0.07 secs] 

[GC (CMS Initial Mark) [1 CMS-initial-mark: 349417K(349568K)] 365297K(506816K), 0.0001600 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

[CMS-concurrent-mark-start]

执行结束!共生成对象次数:348682

Heap

 par new generation   total 157248K, used 21560K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

  eden space 139776K,  15% used [0x00000007a0000000, 0x00000007a150e078, 0x00000007a8880000)

  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

 concurrent mark-sweep generation total 349568K, used 349417K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

 Metaspace       used 2739K, capacity 4490K, committed 4864K, reserved 1056768K

  class space    used 296K, capacity 386K, committed 512K, reserved 1048576K


java  -XX:+UseG1GC -Xms512m  -Xmx512m -XX:+PrintGC GCLogAnalysis

正在执行...

[GC concurrent-root-region-scan-start]

[GC concurrent-root-region-scan-end, 0.0001470 secs]

[GC concurrent-mark-start]

[GC concurrent-mark-end, 0.0023774 secs]

[GC remark, 0.0023176 secs]

[GC cleanup 384M->384M(512M), 0.0004283 secs]

[GC pause (G1 Evacuation Pause) (young)-- 402M->389M(512M), 0.0021376 secs]

[GC pause (G1 Humongous Allocation) (young) (initial-mark) 395M->391M(512M), 0.0012786 secs]

[GC concurrent-root-region-scan-start]

[GC concurrent-root-region-scan-end, 0.0001443 secs]

[GC concurrent-mark-start]

[GC concurrent-mark-end, 0.0019478 secs]

[GC pause (G1 Humongous Allocation) (young)-- 406M->402M(512M), 0.0013094 secs]

[GC remark, 0.0021082 secs]

[GC cleanup 404M->404M(512M), 0.0005139 secs]

[GC pause (G1 Evacuation Pause) (young)-- 407M->407M(512M), 0.0010912 secs]

[Full GC (Allocation Failure)  407M->366M(512M), 0.0458468 secs]

执行结束!共生成对象次数:234403

总结

在Xms=512m和Xmx=512m的情况下，通过GCEasy分析，串行GC的平均GC暂停时间最长，并行GC和CMS GC的平均暂停时间相当，G1平均暂停时间最短
并行GC对年轻代的GC频率比串行GC高，年轻代在没完全满的时候就会触发GC
G1GC在经过短暂的并发标记后，使用的混合GC模式(同时清理年轻代和老年代)和对年轻代的GC模式用时几乎相等
2、使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。

-Xms512m -Xmx512m

java -XX:+UseSerialGC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t16 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    52.29ms  214.29ms   1.87s    93.78%
    Req/Sec     2.70k     0.98k    4.20k    72.36%
  Latency Distribution
     50%  292.00us
     75%  419.00us
     90%    5.52ms
     99%    1.27s
  2073615 requests in 1.00m, 247.57MB read
  Socket errors: connect 0, read 0, write 0, timeout 16
Requests/sec:  34511.27
Transfer/sec:      4.12MB
@2
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.04ms   31.47ms 499.75ms   98.22%
    Req/Sec     3.36k   706.43     5.14k    89.20%
  Latency Distribution
     50%  251.00us
     75%  312.00us
     90%  425.00us
     99%  168.85ms
  2130691 requests in 1.00m, 254.38MB read
Requests/sec:  35466.08
Transfer/sec:      4.23MB

java -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t16 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    26.88ms  136.44ms   1.76s    95.31%
    Req/Sec     2.51k     1.01k    4.42k    65.25%
  Latency Distribution
     50%  304.00us
     75%  429.00us
     90%    1.69ms
     99%  632.28ms
  1949414 requests in 1.00m, 232.74MB read
  Socket errors: connect 0, read 0, write 0, timeout 31
Requests/sec:  32463.77
Transfer/sec:      3.88MB
@2
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    12.63ms   76.11ms   1.03s    96.72%
    Req/Sec     3.01k   719.14     6.49k    81.62%
  Latency Distribution
     50%  277.00us
     75%  359.00us
     90%  543.00us
     99%  437.79ms
  2053135 requests in 1.00m, 245.12MB read
Requests/sec:  34187.09
Transfer/sec:      4.08MB


java -XX:+UseConcMarkSweepGC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t16 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    50.26ms  197.79ms   1.75s    93.38%
    Req/Sec     2.51k     0.99k    4.26k    69.16%
  Latency Distribution
     50%  306.00us
     75%  459.00us
     90%   14.05ms
     99%    1.14s
  1992924 requests in 1.00m, 237.94MB read
Requests/sec:  33164.78
Transfer/sec:      3.96MB

@2
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    17.07ms   86.33ms   1.05s    95.63%
    Req/Sec     2.98k   837.43     4.37k    82.06%
  Latency Distribution
     50%  269.00us
     75%  357.00us
     90%  682.00us
     99%  492.20ms
  2274112 requests in 1.00m, 271.51MB read
  Socket errors: connect 0, read 0, write 0, timeout 48
Requests/sec:  37856.45
Transfer/sec:      4.52MB


java -XX:+UseG1GC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t16 -d60s --latency http://localhost:8088/api/hello
@1
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    34.20ms  155.24ms   1.67s    94.89%
    Req/Sec     2.08k     1.04k    6.20k    58.58%
  Latency Distribution
     50%  337.00us
     75%  546.00us
     90%   16.75ms
     99%  909.53ms
  1731574 requests in 1.00m, 206.73MB read
Requests/sec:  28815.48
Transfer/sec:      3.44MB
@2
Running 1m test @ http://localhost:8088/api/hello
  16 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    31.06ms  129.69ms   1.37s    93.97%
    Req/Sec     2.76k     0.91k    8.93k    77.94%
  Latency Distribution
     50%  291.00us
     75%  405.00us
     90%    1.89ms
     99%  721.63ms
  2172125 requests in 1.00m, 259.33MB read
  Socket errors: connect 0, read 0, write 0, timeout 16
Requests/sec:  36140.70
Transfer/sec:      4.31MB
wrk使用4个线程

java -XX:+UseSerialGC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t4 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    46.77ms  184.99ms   1.69s    94.04%
    Req/Sec    10.87k     4.08k   22.34k    73.28%
  Latency Distribution
     50%  491.00us
     75%  837.00us
     90%   50.75ms
     99%    1.06s
  2242422 requests in 1.00m, 267.72MB read
  Socket errors: connect 0, read 0, write 0, timeout 28
Requests/sec:  37349.01
Transfer/sec:      4.46MB
@2
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    41.46ms  152.93ms   1.32s    93.15%
    Req/Sec    11.26k     3.61k   22.42k    74.63%
  Latency Distribution
     50%  483.00us
     75%  781.00us
     90%   63.16ms
     99%  863.88ms
  2362874 requests in 1.00m, 282.10MB read
Requests/sec:  39236.93
Transfer/sec:      4.68MB

java -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t4 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    23.87ms  106.66ms   1.09s    95.02%
    Req/Sec     9.47k     4.10k   21.58k    62.11%
  Latency Distribution
     50%  553.00us
     75%    0.98ms
     90%   12.41ms
     99%  662.96ms
  2126825 requests in 1.00m, 253.92MB read
Requests/sec:  35409.21
Transfer/sec:      4.23MB
@2
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    54.81ms  190.06ms   1.74s    92.01%
    Req/Sec    13.57k     3.77k   29.39k    85.08%
  Latency Distribution
     50%  424.00us
     75%  604.00us
     90%  163.97ms
     99%    1.07s
  2614503 requests in 1.00m, 312.15MB read
Requests/sec:  43514.75
Transfer/sec:      5.20MB


java -XX:+UseConcMarkSweepGC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t4 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    47.39ms  193.33ms   1.58s    94.64%
    Req/Sec    10.08k     3.83k   22.34k    69.36%
  Latency Distribution
     50%  538.00us
     75%    0.94ms
     90%   43.10ms
     99%    1.19s
  2172779 requests in 1.00m, 259.41MB read
Requests/sec:  36158.73
Transfer/sec:      4.32MB

@2
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    73.36ms  229.37ms   1.63s    91.51%
    Req/Sec    12.41k     3.54k   22.81k    81.70%
  Latency Distribution
     50%  458.00us
     75%  741.00us
     90%  225.15ms
     99%    1.20s
  2494848 requests in 1.00m, 297.86MB read
Requests/sec:  41526.75
Transfer/sec:      4.96MB


java -XX:+UseG1GC -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t4 -d60s --latency http://localhost:8088/api/hello
@1
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    16.04ms   77.13ms 997.12ms   95.29%
    Req/Sec    10.41k     3.98k   19.15k    74.95%
  Latency Distribution
     50%  508.00us
     75%  785.00us
     90%    5.70ms
     99%  386.38ms
  2210757 requests in 1.00m, 263.94MB read
Requests/sec:  36806.69
Transfer/sec:      4.39MB
@2
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    28.56ms  105.71ms   1.13s    92.71%
    Req/Sec    12.04k     3.75k   27.19k    80.36%
  Latency Distribution
     50%  464.00us
     75%  673.00us
     90%   62.26ms
     99%  536.45ms
  2622636 requests in 1.00m, 313.12MB read
Requests/sec:  43642.93
Transfer/sec:      5.21MB
测试一下G1 GC的MaxGCPauseMillis

java -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar
wrk -c 30 -t4 -d60s --latency http://localhost:8088/api/hello

@1
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    26.12ms  121.07ms   1.37s    95.55%
    Req/Sec     8.46k     3.71k   27.50k    67.74%
  Latency Distribution
     50%  626.00us
     75%    1.14ms
     90%   16.00ms
     99%  679.41ms
  1902930 requests in 1.00m, 227.19MB read
Requests/sec:  31661.53
Transfer/sec:      3.78MB
@2
Running 1m test @ http://localhost:8088/api/hello
  4 threads and 30 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.61ms   42.24ms 535.14ms   96.33%
    Req/Sec    13.36k     3.49k   23.12k    84.55%
  Latency Distribution
     50%  421.00us
     75%  540.00us
     90%  807.00us
     99%  248.05ms
  2475893 requests in 1.00m, 295.60MB read
Requests/sec:  41202.30
Transfer/sec:      4.92MB
总结

java程序经过预热之后吞吐量和响应时间都更好
并行GC比串行GC的吞吐量高，但延时也高，并行GC和CMS GC、G1 GC性能相当
吞吐量越高，延时也越高，G1 GC能在较高的吞吐量下还能保持较低的延迟
G1 GC设置了MaxGCPauseMillis吞吐量不会降低太多，但延迟降低了非常多
