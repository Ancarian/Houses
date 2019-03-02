FROM node:9-alpine as builder


COPY package.json package-lock.json ./
RUN npm i -g npm@6.3 && npm ci && mkdir /ng-app && mv ./node_modules ./ng-app/
WORKDIR /ng-app
COPY . .
ARG NG_ENV=production
RUN npm run ng build -- --configuration=$NG_ENV
FROM nginx:1.13.3-alpine
COPY nginx/default.conf /etc/nginx/conf.d/
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /ng-app/dist /usr/share/nginx/html/

CMD ["nginx", "-g", "daemon off;"]