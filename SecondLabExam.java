package CCE105LAB;

import java.util.*;


	
	class Patient implements Comparable<Patient>{
		
		Scanner scan = new Scanner(System.in);
		
		
		String name;
		int priority;
		String condition;
		String arrivalTime;
		
		public Patient(String name, int priority, String condition, String arrivalTime ) {
			
			this.name = name;
			this.priority = priority;
			this.condition = condition;
			this.arrivalTime = arrivalTime;
			
		}

		@Override
		public int compareTo(Patient other) {
			if (this.priority != other.priority) {
				return this.priority - other.priority;
			}
		return this.arrivalTime.compareTo(other.arrivalTime);
		
		}
		public String toString() {
			return String.format("[P%d] %s | %s (%s)",
					priority, name, condition, arrivalTime);
		}
	
		
	}
	
	
	class ERQueue{
		
		PriorityQueue<Patient> queue;
		
		public ERQueue() {
			queue = new PriorityQueue<>();
		}
		
		void arrive(String name, int priority, String condition, String time){
			Patient patient = new Patient(name, priority, condition, time);
			queue.add(patient);
		}
		void treatNext() {
			if (queue.isEmpty()) {
				System.out.println(">>> No patient to treat");
			}else {
				Patient next = queue.poll();
				System.out.println(">>> Treating patient now...");
				System.out.println("Treated: " + next);
			}
			
		}
		void displayQueue() {
			System.out.println("\n === UPDATED QUEUE ===");
			System.out.println("Patients Waiting: " + queue.size());
			
			List<Patient> ordered = new ArrayList<>(queue);
			Collections.sort(ordered);
			int i = 1;
			for (Patient patient : ordered) {
				System.out.println(i++ + " " + patient);
			}
			
		}
	}
	public class SecondLabExam {
		
	public static void main (String[]args) {
		ERQueue er = new ERQueue();
		 
		er.arrive("Pedro Cruz", 1, "Head injury - NOW UNCONSCIOUS ⚠️", "23:52");
		er.arrive("Carlos Mendoza", 2, "Compound fracture - leg", "23:50");
		er.arrive("Lisa Wang", 2, "Severe asthma attack", "23:56");
		er.arrive("Maria Santos", 3, "Deep laceration on arm", "23:48");
		er.arrive("Ana Lim", 4, "Sprained ankle", "23:49");
		 
		er.displayQueue();
		er.treatNext();
		er.displayQueue();
		
		
	}

}
