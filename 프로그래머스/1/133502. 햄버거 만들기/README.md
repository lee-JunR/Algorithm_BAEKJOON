# [level 1] 햄버거 만들기 - 133502 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133502) 

### 성능 요약

메모리: 9.99 MB, 시간: 0.01 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 04월 01일 21:52:52

### 문제 설명

<p element-id="157">햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈  재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,  재료의 높이는 무시하여  재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.</p>

<p element-id="156">예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.</p>

<p element-id="155">상수에게 전해지는 재료의 정보를 나타내는 정수 배열 <code element-id="154">ingredient</code>가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.</p>

<hr element-id="153">

<h5 element-id="152">제한사항</h5>

<ul element-id="151">
<li element-id="150">1 ≤ <code element-id="149">ingredient</code>의 길이 ≤ 1,000,000</li>
<li element-id="148"><code element-id="147">ingredient</code>의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.</li>
</ul>

<hr element-id="146">

<h5 element-id="145">입출력 예</h5>
<table class="table" element-id="144">
        <thead element-id="143"><tr element-id="142">
<th element-id="141">ingredient</th>
<th element-id="140">result</th>
</tr>
</thead>
        <tbody element-id="139"><tr element-id="138">
<td element-id="137">[2, 1, 1, 2, 3, 1, 2, 3, 1]</td>
<td element-id="136">2</td>
</tr>
<tr element-id="135">
<td element-id="134">[1, 3, 2, 1, 2, 1, 3, 1, 2]</td>
<td element-id="133">0</td>
</tr>
</tbody>
      </table>
<hr element-id="132">

<h5 element-id="131">입출력 예 설명</h5>

<p element-id="130"><strong element-id="129">입출력 예 #1</strong></p>

<ul element-id="128">
<li element-id="127">문제 예시와 같습니다.</li>
</ul>

<p element-id="126"><strong element-id="125">입출력 예 #2</strong></p>

<ul element-id="124">
<li element-id="123">상수가 포장할 수 있는 햄버거가 없습니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges