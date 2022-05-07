import SwiftUI
import shared

struct ContentView: View {
    
    @StateObject private var viewModel = ViewModel()
    
	var body: some View {
        
        ZStack {
            VStack {
                HStack {
                    Text(String(viewModel.problem?.left ?? 0))
                    Text(getOperationString(operation: viewModel.problem?.operation))
                    Text(String(viewModel.problem?.right ?? 0))
                    
                }
                Spacer()
                    .frame(height: 16)
                Text(viewModel.result)
                Spacer()
                    .frame(height: 16)
                HStack {
                    Button(action: { viewModel.submitDigit(digit: "1") }) {
                        Text("1")
                    }
                    Button(action: { viewModel.submitDigit(digit: "2") }) {
                        Text("2")
                    }
                    Button(action: { viewModel.submitDigit(digit: "3") }) {
                        Text("3")
                    }
                }
                HStack {
                    Button(action: { viewModel.submitDigit(digit: "4") }) {
                        Text("4")
                    }
                    Button(action: { viewModel.submitDigit(digit: "5") }) {
                        Text("5")
                    }
                    Button(action: { viewModel.submitDigit(digit: "6") }) {
                        Text("6")
                    }
                }
                HStack {
                    Button(action: { viewModel.submitDigit(digit: "7") }) {
                        Text("7")
                    }
                    Button(action: { viewModel.submitDigit(digit: "8") }) {
                        Text("8")
                    }
                    Button(action: { viewModel.submitDigit(digit: "9") }) {
                        Text("9")
                    }
                }
                HStack {
                    Button(action: { viewModel.submitDigit(digit: "0") }) {
                        Text("0")
                    }
                    Button(action: { viewModel.submitNegative() }) {
                        Text("-")
                    }
                    Button(action: { viewModel.backspace() }) {
                        Text("B")
                    }
                }
                Spacer()
                    .frame(height: 16)
                Button(action: { viewModel.submitResult() }) {
                    Text("Submit")
                }
            }
            VStack {
                HStack {
                    Spacer()
                    Text(viewModel.total)
                }.padding()
                Spacer()
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
    
    func getOperationString(operation: shared.Operation?) -> String {
        if (operation is shared.Operation.Addition) {
            return "+"
        } else if (operation is shared.Operation.Multiplication) {
            return "*"
        } else if (operation is shared.Operation.Division) {
            return "/"
        } else if (operation is shared.Operation.Subtraction) {
            return "-"
        }
        
        return ""
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
