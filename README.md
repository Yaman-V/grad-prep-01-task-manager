# grad-prep-01-task-manager

Phase 1 of our university capstone preparation. A full-stack task manager built to establish our core architecture, development workflow, and team collaboration practices.

## Structure

This project has:

```text
grad-prep-01-task-manager/
├── frontend/        # React application
├── backend/         # Spring Boot application
├── .gitignore
└── README.md
```

- `/frontend` contains the React frontend.
- `/backend` contains the Spring Boot backend.
- Configuration files such as `.gitignore` and `.env.example` are kept in the project where needed.

> Do not commit secrets or sensitive information to `.env` files. Use `.env.example` to document required environment variables.

---

## Rules

1. The `main` branch is protected. No direct commits or force pushes are allowed.
2. All changes must go through a Pull Request (PR) and be reviewed before being merged into `main`.
3. We follow naming conventions for branches and commits.

### Commits

We use [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).

Format:

```text
<type>[optional scope]: <description>
```

Examples:

```text
feat(task): add task creation
fix(auth): handle expired token
docs: update README
```

### Branches

Branch names should follow:

```text
<type>/<description>
```

Examples:

```text
feature/add-task
fix/task-validation
refactor/task-service
docs/update-readme
```

---

## How to build and run locally

### Backend

1. Make sure your local branch is up to date:

```bash
git pull
```

2. Go to the backend directory:

```bash
cd backend
```

3. Build the Spring Boot project:

```bash
.\mvnw.cmd clean package
```

4. Run the Spring Boot application:

```bash
.\mvnw.cmd spring-boot:run
```

### Frontend

_Not available yet._

---

## Development Workflow

1. Create a new branch from `main`.
2. Make your changes and commit them using the commit convention.
3. Push your branch.
4. Open a Pull Request.
5. Get the changes reviewed.
6. Merge into `main` after approval.
