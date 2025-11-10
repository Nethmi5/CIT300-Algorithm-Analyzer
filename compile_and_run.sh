#!/bin/bash
echo "CIT300 Algorithm Analyzer - Compilation and Execution"
echo "====================================================="

# Compile all Java files
echo "Compiling Java files..."
javac src/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "Running Algorithm Analyzer..."
    echo "============================="
    
    # Run the program
    cd src
    java AlgorithmAnalyzer
else
    echo "Compilation failed! Please check your Java installation."
fi