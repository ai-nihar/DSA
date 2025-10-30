# DSA-Progress

Personal DSA learning tracker and solutions repository.

---
## Structure
- `phases/` — learning phases (phase-00-prerequisites, phase-01-arrays, ...)
    - each phase contains:
        - `progress.md` — summary of what was learned in that phase
        - `notes/` — concept notes
        - `solutions/` — solved problems (one folder per problem: `<id>-<kebab-name>/`)
            - `solution.java` and `README.md` in each problem folder

---
## How I use this repo
1. Work on a topic (phase). Update `phases/phase-XX-.../progress.md` with short summary and links.
2. For each solved problem create a new folder under `solutions/`:
    - `<leetcode-id>-<kebab-slug>/solution.java`
    - `<leetcode-id>-<kebab-slug>/README.md`
3. Commit with message: `feat: add solution <leetcode-id> - <title>`

---
## Conventions
- Java solutions go in `solution.java`.
- Problem folder names use kebab-case: `1480-running-sum`.
- Each `README.md` in a problem folder must include: Problem link, Approach summary, Complexity, Edge cases.