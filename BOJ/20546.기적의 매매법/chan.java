import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int jh_cash = input;
		int sm_cash = input;
		
		int[] MachineDuck = new int[14];
		String[] data = br.readLine().split(" ");
		for (int i = 0; i < 14; i++) {
			MachineDuck[i] = Integer.parseInt(data[i]);
		}
		//입력받기 완료 - 준현이와 성민이가 가진 돈과, 14일간의 MachineDuck 주가
		
		// 준현과 성민이 산 주식 수 초기화
		int jh_stock = 0;
		// 준현의 BNP 전략
		for (int i = 0; i < 14; i++) {
			if (jh_cash / MachineDuck[i] > 0) {
				jh_stock += jh_cash / MachineDuck[i];
				jh_cash = jh_cash % MachineDuck[i];
			}
		}
		// 성민의 33 매매법
		int sm_stock = 0;
		int up = 0;
		int down = 0;
		for (int i = 1; i < 14; i++) {
			if (MachineDuck[i] - MachineDuck[i - 1] > 0) {
				up++; down = 0;
			} else if (MachineDuck[i] - MachineDuck[i - 1] < 0) {
				down++; up = 0;
			}
			
			if (up == 3) {
				sm_cash = sm_stock * MachineDuck[i];
				sm_stock = 0;
			} else if (down >= 3 && sm_cash / MachineDuck[i] > 0) {
				sm_stock += sm_cash / MachineDuck[i];
				sm_cash = sm_cash % MachineDuck[i];
			}
		} 
		
		
	}

}
