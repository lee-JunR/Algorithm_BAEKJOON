# [level 1] 바탕화면 정리 - 161990 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/161990) 

### 성능 요약

메모리: 10.2 MB, 시간: 0.21 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 03월 28일 22:34:05

### 문제 설명

<p element-id="376">코딩테스트를 준비하는 머쓱이는 프로그래머스에서 문제를 풀고 나중에 다시 코드를 보면서 공부하려고 작성한 코드를 컴퓨터 바탕화면에 아무 위치에나 저장해 둡니다. 저장한 코드가 많아지면서 머쓱이는 본인의 컴퓨터 바탕화면이 너무 지저분하다고 생각했습니다. 프로그래머스에서 작성했던 코드는 그 문제에 가서 다시 볼 수 있기 때문에 저장해 둔 파일들을 전부 삭제하기로 했습니다.</p>

<p element-id="375">컴퓨터 바탕화면은 각 칸이 정사각형인 격자판입니다. 이때 컴퓨터 바탕화면의 상태를 나타낸 문자열 배열 <code element-id="374">wallpaper</code>가 주어집니다. 파일들은 바탕화면의 격자칸에 위치하고 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를 (0, 0)으로 시작해 (세로 좌표, 가로 좌표)로 표현합니다. 빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다. 드래그를 하면 파일들을 선택할 수 있고, 선택된 파일들을 삭제할 수 있습니다. 머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법은 다음과 같습니다.</p>

<ul element-id="373">
<li element-id="372"><p element-id="371">드래그는 바탕화면의 격자점 S(<code element-id="370">lux</code>, <code element-id="369">luy</code>)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(<code element-id="368">rdx</code>, <code element-id="367">rdy</code>)로 이동한 뒤 마우스 왼쪽 버튼을 떼는 행동입니다. 이때, "<strong element-id="366">점 S에서 점 E로 드래그한다</strong>"고 표현하고 점 S와 점 E를 각각 드래그의 시작점, 끝점이라고 표현합니다.</p></li>
<li element-id="365"><p element-id="364">점 S(<code element-id="363">lux</code>, <code element-id="362">luy</code>)에서 점 E(<code element-id="361">rdx</code>, <code element-id="360">rdy</code>)로 드래그를 할 때, "<strong element-id="359">드래그 한 거리</strong>"는 |<code element-id="358">rdx</code> - <code element-id="357">lux</code>| + |<code element-id="356">rdy</code> - <code element-id="355">luy</code>|로 정의합니다.</p></li>
<li element-id="354"><p element-id="353">점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이 선택됩니다.</p></li>
</ul>

<p element-id="352">예를 들어 <code element-id="351">wallpaper</code> = [".#...", "..#..", "...#."]인 바탕화면을 그림으로 나타내면 다음과 같습니다.<br element-id="350">
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ec8b3f44-17e9-4044-8117-fad0f1f4402f/eg1.png" title="" alt="eg1.png" element-id="349"><br element-id="348">
이러한 바탕화면에서 다음 그림과 같이 S(0, 1)에서 E(3, 4)로 드래그하면  세 개의 파일이 모두 선택되므로  드래그 한 거리 (3 - 0) + (4 - 1) = 6을 최솟값으로 모든 파일을 선택 가능합니다.<br element-id="347">
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e69e8776-4e56-4abb-b2a7-3dc695620ef4/eg1-2.png" title="" alt="eg1-2.png" element-id="346"><br element-id="345">
(0, 0)에서 (3, 5)로 드래그해도 모든 파일을 선택할 수 있지만 이때 드래그 한 거리는 (3 - 0) + (5 - 0) = 8이고 이전의 방법보다 거리가 늘어납니다.</p>

<p element-id="344">머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 <code element-id="343">wallpaper</code>가 매개변수로 주어질 때 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return하는 <code element-id="342">solution</code> 함수를 작성해 주세요. 드래그의 시작점이 (<code element-id="341">lux</code>, <code element-id="340">luy</code>), 끝점이 (<code element-id="339">rdx</code>, <code element-id="338">rdy</code>)라면 정수 배열 [<code element-id="337">lux</code>, <code element-id="336">luy</code>, <code element-id="335">rdx</code>, <code element-id="334">rdy</code>]를 return하면 됩니다.</p>

<hr element-id="333">

<h4 element-id="332">제한사항</h4>

<ul element-id="331">
<li element-id="330"> 1 ≤ <code element-id="329">wallpaper</code>의 길이 ≤ 50</li>
<li element-id="328">1 ≤ <code element-id="327">wallpaper[i]</code>의 길이 ≤ 50

<ul element-id="326">
<li element-id="325"><code element-id="324">wallpaper</code>의 모든 원소의 길이는 동일합니다.</li>
</ul></li>
<li element-id="323"><code element-id="322">wallpaper[i][j]</code>는 바탕화면에서 <code element-id="321">i + 1</code>행 <code element-id="320">j + 1</code>열에 해당하는 칸의 상태를 나타냅니다.</li>
<li element-id="319"><code element-id="318">wallpaper[i][j]</code>는 "#" 또는 "."의 값만 가집니다.</li>
<li element-id="317">바탕화면에는 적어도 하나의 파일이 있습니다.</li>
<li element-id="316">드래그 시작점 (<code element-id="315">lux</code>, <code element-id="314">luy</code>)와 끝점 (<code element-id="313">rdx</code>, <code element-id="312">rdy</code>)는 <code element-id="311">lux</code> &lt; <code element-id="310">rdx</code>, <code element-id="309">luy</code> &lt; <code element-id="308">rdy</code>를 만족해야 합니다.</li>
</ul>

<hr element-id="307">

<h4 element-id="306">입출력 예</h4>
<table class="table" element-id="305">
        <thead element-id="304"><tr element-id="303">
<th element-id="302">wallpaper</th>
<th element-id="301">result</th>
</tr>
</thead>
        <tbody element-id="300"><tr element-id="299">
<td element-id="298">[".#...", "..#..", "...#."]</td>
<td element-id="297">[0, 1, 3, 4]</td>
</tr>
<tr element-id="296">
<td element-id="295">["..........", ".....#....", "......##..", "...##.....", "....#....."]</td>
<td element-id="294">[1, 3, 5, 8]</td>
</tr>
<tr element-id="293">
<td element-id="292">[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]</td>
<td element-id="291">[0, 0, 7, 9]</td>
</tr>
<tr element-id="290">
<td element-id="289">["..", "#."]</td>
<td element-id="288">[1, 0, 2, 1]</td>
</tr>
</tbody>
      </table>
<hr element-id="287">

<h4 element-id="286">입출력 예 설명</h4>

<p element-id="285">입출력 예 #1</p>

<ul element-id="284">
<li element-id="283">문제 설명의 예시와 같은 예제입니다. (0, 1)에서 (3, 4)로 드래그 하면 모든 파일을 선택할 수 있고 드래그 한 거리는 6이었고, 6보다 적은 거리로 모든 파일을 선택하는 방법은 없습니다. 따라서 [0, 1, 3, 4]를 return합니다.</li>
</ul>

<p element-id="282">입출력 예 #2</p>

<ul element-id="281">
<li element-id="280"><p element-id="279">예제 2번의 바탕화면은 다음과 같습니다.</p>

<p element-id="278"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8bf4e2ba-1700-4231-a6ed-c18455919928/eg2.png" title="" alt="eg2.png" element-id="277"></p>

<p element-id="276">(1, 3)에서 (5, 8)로 드래그하면 모든 파일을 선택할 수 있고 이보다 적은 이동거리로 모든 파일을 선택하는 방법은 없습니다. 따라서 가장 적은 이동의 드래그로 모든 파일을 선택하는 방법인 [1, 3, 5, 8]을 return합니다.</p></li>
</ul>

<p element-id="275">입출력 예 #3</p>

<ul element-id="274">
<li element-id="273"><p element-id="272">예제 3번의 바탕화면은 다음과 같습니다.</p>

<p element-id="271"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7cc308f7-b8d7-482e-9e06-18bc1133aea0/eg3.png" title="" alt="eg3.png" element-id="270"></p>

<p element-id="269">모든 파일을 선택하기 위해선 바탕화면의 가장 왼쪽 위 (0, 0)에서 가장 오른쪽 아래 (7, 9)로 드래그 해야만 합니다. 따라서 [0, 0, 7, 9]를 return합니다.</p></li>
</ul>

<p element-id="268">입출력 예 #4</p>

<ul element-id="267">
<li element-id="266"><p element-id="265">예제 4번의 바탕화면은 다음과 같이 2행 1열에만 아이콘이 있습니다.</p>

<p element-id="264"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/5f726562-04dd-4056-8dd7-e58d1519f6ec/eg4.png" title="" alt="eg4.png" element-id="263"></p>

<p element-id="262">이를 드래그로 선택하기 위해서는 그 칸의 왼쪽 위 (1, 0)에서 오른쪽 아래 (2, 1)로 드래그 하면 됩니다. (1, 0)에서 (2, 2)로 드래그 해도 아이콘을 선택할 수 있지만 이전보다 이동거리가 늘어납니다. 따라서 [1, 0, 2, 1]을 return합니다.</p></li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges