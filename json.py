import os

# List of JSON file names
file_names = [
    "150121028",
    "150120527",
    "150119817",
    "150121066",
    "150121063",
    "150120057",
    "150122073",
    "150122529",
    "150120995",
    "150121065",
    "150119910",
    "150119916",
    "150121001",
    "150121521",
    "150121038",
    "150121042",
    "150122992",
    "150120031",
    "150121852",
    "150122066",
    "150122045",
    "150121007",
    "150119705",
    "150121077",
    "150122052",
    "150121058",
    "150120024",
    "150121922",
    "150122022",
    "150119917",
    "150122058",
    "150122075",
    "150121040",
    "150122006"
]

# Directory to save the JSON files
output_directory = "json_files"

# Create the directory if it doesn't exist
if not os.path.exists(output_directory):
    os.makedirs(output_directory)

# Create empty JSON files
for file_name in file_names:
    file_path = os.path.join(output_directory, f"{file_name}.json")
    with open(file_path, "w") as json_file:
        pass  # Creates an empty JSON file

print("Empty JSON files have been created.")
