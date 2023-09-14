public class Testquicksort {
    public static void main(String[] args) {

    }
    public void quicksort(int[] arr,int low, int high){
        if (low < high) {
        int partition =partition(arr, low,  high);
        quicksort(arr,low,partition-1);
        quicksort(arr,partition+1,high);
        }
    }
    public int partition(int[] arr,int low,int high ){
        int privot = arr[high];
        int pointer =low;
        for(int i=low;i<high;i++){
            if(arr[i]<privot){
                int temp = arr[i];
                arr[i]=arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
        int temp = arr[high];
        arr[high]=arr[pointer];
        arr[pointer] = temp;
        return pointer;
    }
}
