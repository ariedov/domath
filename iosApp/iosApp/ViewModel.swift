//
//  ViewModel.swift
//  iosApp
//
//  Created by David Leybovich on 07.05.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

extension ContentView {
    
    @MainActor class ViewModel : ObservableObject {
        @Published var problem: Problem?
        @Published var result: String = ""
        @Published var total: String = "0 / 0"
        
        private let problemGenerator = MathProblemsGenerator(random: KotlinRandom.Default())
        private let resultWrapper = SuggestedResultWrapper()
        private let practiceTracker = PracticeTracker()
        
        init() {
            result = resultWrapper.clear()
            practiceTracker.clear()

            problem = problemGenerator.generateMathProblem()
            total = String(practiceTracker.correct) + " / " + String(practiceTracker.total)
        }
        
        func submitDigit(digit: String) {
            result = resultWrapper.submitDigit(digit: digit)
        }
        
        func submitNegative() {
            result = resultWrapper.submitNegative()
        }
        
        func backspace() {
            result = resultWrapper.backspace()
        }
        
        func submitResult() {
            guard let unwrapProblem = problem else { return }
            
            practiceTracker.submitResult(problem: unwrapProblem, result: result)
            
            result = resultWrapper.clear()
            problem = problemGenerator.generateMathProblem()
            total = String(practiceTracker.correct) + " / " + String(practiceTracker.total)
        }
    }
}
