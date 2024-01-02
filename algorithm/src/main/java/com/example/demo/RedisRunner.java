class Solution {

    Number[] numberArray;

    public static final int MAX = 1;
    public static final int MIN = 0;

    public int solution(String arr[]) {





        /*
            1. 뒤에서부터 계산한다
            2. + 는 영향을 안줌 식 안에서
            3. - 가 나올 때 최대값을 만들어야하는지 최소를 만들어야하는지 구분해서 둘다보관
            -홀수개로나오면 최소값을 만들어야함
            a-b > 최대로 나오려면 b가 최소여야함 ㅇㅋ?
            a-(b-(c+d) > 1.최대로 나오려면 c+d가 최소여야함 > 2.c+d는 최대값 , b는 최소값
            a-b+(c+d)
            4. 마지막에 최대값을 arr[0]에 더해서 return;
         */










        int answer = Integer.parseInt(arr[0]);

        int[] totalSum = new int[2];
        int tempSum = 0;
        setNumberArray(arr);

        for(int i = numberArray.length -1; i >= 0; i-- ){
            if("-".equals(numberArray[i].getOperator())){
                int[] temp = {totalSum[MIN], totalSum[MAX]};
                totalSum[MIN] = Math.min(-(temp[MAX] + tempSum), temp[MIN] - tempSum);
                totalSum[MAX] = Math.max(-(temp[MIN] + tempSum), temp[MAX] + tempSum - (2 * numberArray[i].getValue()));
                tempSum=0;
            } else {
                tempSum += numberArray[i].getValue();
            }
        }

        return answer + totalSum[MAX];
    }

    private void setNumberArray(String[] arr){
        numberArray = new Number[(arr.length-1)/2];

        for(int i = 0; i < numberArray.length; i++){
            numberArray[i] = new Number(arr[i * 2 + 1], Integer.parseInt(arr[(i + 1) * 2]));
        }
    }
}

class Number{
    private String operator;
    private int value;

    public Number(String operator, int value) {
        this.operator = operator;
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}