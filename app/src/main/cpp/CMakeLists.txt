cmake_minimum_required(VERSION 3.22.1)

project(damas_engine LANGUAGES CXX)

add_library(damas_engine SHARED native_engine.cpp)
target_compile_features(damas_engine PRIVATE cxx_std_17)
target_compile_options(damas_engine PRIVATE -Wall -Wextra -Wpedantic)

find_library(android_log log)
target_link_libraries(damas_engine PRIVATE ${android_log})
